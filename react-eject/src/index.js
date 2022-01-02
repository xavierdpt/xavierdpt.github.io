import { belowleft, rightof, topleft, mergeBoundingRects } from "./geometry";
import _, { isArray } from "underscore";
import "./index.css";
import { useCallback } from "react";
const anime = window.anime;
const debug = false;
const speedFactor = .01;
const DEBUG_OPACITY = 0.3;

const u = (x, d) => (x === undefined || x === null ? d : x);

const foo = (supplier) => {
  if (!supplier) {
    return;
  }
  if (typeof supplier.next !== "function") {
    if (typeof supplier === "function") {
      // supplier acting as callback
      supplier();
    }
  } else {
    const actionfn = supplier.next().value;
    if (!actionfn) {
      return;
    }
    const action = actionfn(supplier);
    if (!action) {
      return;
    }
    action();
  }
};

const SIZES = { normal: "div", big: "h1" };

const createText = (text, root, options = {}) => {
  const h1 = document.createElement(SIZES[u(options.size, "big")]);
  h1.style.display = "inline-block";
  h1.style.position = "absolute";
  const span = document.createElement("span");
  const letters = document.createElement("span");
  const letterNodes = [];
  for (let i = 0; i < text.length; ++i) {
    const letter = document.createElement("span");
    letter.style.opacity = debug ? DEBUG_OPACITY : 0;
    letter.appendChild(document.createTextNode(text[i]));
    letters.appendChild(letter);
    letterNodes.push(letter);
  }
  span.appendChild(letters);
  h1.appendChild(span);
  root.appendChild(h1);
  return { node: h1, letterNodes };
};

const animateAppear = (elements, supplier, options = {}) => {
  anime.timeline().add({
    targets: elements,
    opacity: [0, 1],
    easing: "easeOutExpo",
    duration: 1,
    delay: (el, i) =>
      (u(options.elementDelay, 30) * (i + 1) + u(options.delay, 0)) *
      speedFactor,
    complete: () => foo(supplier),
  });
};

const animateAppearText = (text, supplier) => {
  animateAppear(text.letterNodes, supplier);
};

const animateDisappear = (elements, supplier) => {
  anime
    .timeline({
      loop: false,
      duration: 10000,
    })
    .add({
      targets: elements,
      opacity: [1, 0],
      easing: "easeOutExpo",
      duration: 1,
      delay: (el, i) => 30 * (i + 1),
      complete: () => foo(supplier),
    });
};

const animateMove = (supplier) => {
  anime.timeline({ loop: false }).add({
    targets: "#root",
    left: [0, 100],
    top: [0, 50],
    easing: "linear",
    duration: 100,
    complete: () => foo(supplier),
  });
};

const centerOn = (elements, root, supplier) => {
  const focusArea = mergeBoundingRects(...elements);
  const nfp = {
    x: focusArea.right - focusArea.width / 2,
    y: focusArea.bottom - focusArea.height / 2,
  };

  const r = root.getBoundingClientRect();
  const cfp = {
    x: r.right - r.width / 2,
    y: r.bottom - r.height / 2,
  };
  const d = { x: cfp.x - nfp.x - r.x, y: cfp.y - nfp.y - r.y };
  anime.timeline().add({
    targets: root,
    left: Math.floor(r.left + d.x),
    top: Math.floor(r.top + d.y),
    easing: "linear",
    duration: 200 * speedFactor,
    complete: () => foo(supplier),
  });
};

const animatePath = (path, pathLength, supplier, options = {}) => {
  anime.timeline({ loop: false }).add({
    targets: path,
    strokeDashoffset: [pathLength, 0],
    easing: "linear",
    duration: u(options.duration, 1000) * speedFactor,
    complete: () => foo(supplier),
  });
};

const sleep = (duration, supplier) => {
  setTimeout(() => foo(supplier), duration);
};

const pause = (supplier) => sleep(1000, supplier);

const parallel = (total, supplier) => {
  let current = 0;
  return () => {
    ++current;
    if (current === total) {
      foo(supplier);
    }
  };
};

const createTable = (words) => {
  const table = document.createElement("table");
  table.style.position = "absolute";

  const tbody = document.createElement("tbody");
  const trs = [];
  const lines = [];
  for (const word of words) {
    const tr = document.createElement("tr");
    const td = document.createElement("td");
    const line = [];
    for (let i = 0; i < word.length; ++i) {
      const letter = document.createElement("span");
      letter.appendChild(document.createTextNode(word[i]));
      letter.style.opacity = debug ? DEBUG_OPACITY : 0;
      td.appendChild(letter);
      line.push(letter);
    }
    tr.appendChild(td);
    tbody.appendChild(tr);
    trs.push(tr);
    lines.push(line);
    trs.push(tr);
  }
  table.appendChild(tbody);
  root.appendChild(table);

  return { table, lines, trs };
};

const computeStops = (trs) => {
  const stops = [];
  let tw = undefined;
  for (let i = 0; i < trs.length; ++i) {
    const tr = trs[i];
    const r = tr.getBoundingClientRect();
    stops.push(r.y);
    if (i === trs.length - 1) {
      stops.push(r.y + r.height);
    }
    tw = r.width;
  }
  return { stops, tw };
};

const createTableSvg = (tw, stops) => {
  const table_height = Math.floor(stops[stops.length - 1] - stops[0]);
  const svg = document.createElementNS("http://www.w3.org/2000/svg", "svg");
  svg.setAttributeNS(null, "width", "" + tw);
  svg.setAttributeNS(null, "height", "" + table_height);
  svg.style.position = "absolute";
  svg.style.left = "10px";
  svg.style.top = "10px";
  const path = document.createElementNS("http://www.w3.org/2000/svg", "path");

  path.setAttributeNS(null, "d", "M 0 0 v " + table_height);
  path.setAttributeNS(null, "stroke", "blue");
  path.setAttributeNS(null, "stroke-width", "2");
  path.setAttributeNS(null, "fill", "none");
  svg.appendChild(path);
  root.appendChild(svg);
  const pathLength = path.getTotalLength();
  path.style.strokeDasharray = pathLength;
  path.style.strokeDashoffset = pathLength;
  return { svg, path, pathLength };
};

const createTableComplete = (words) => {
  const { table, lines, trs } = createTable(words);
  const { stops, tw } = computeStops(trs);
  const { svg, path, pathLength } = createTableSvg(tw, stops);
  return { table, lines, svg, path, pathLength };
};

const animateAppearTable = (table2, supplier) => {
  const proceed = parallel(table2.lines.length + 1, supplier);
  for (let i = 0; i < table2.lines.length; ++i) {
    const line = table2.lines[i];
    animateAppear(line, proceed, { delay: i * 500, elementDelay: 30 });
  }
  animatePath(table2.path, table2.pathLength, proceed, {
    duration: 500 * table2.lines.length + 30,
  });
};

const animateAppearAny = (any, supplier) => {
  if (any.table) {
    animateAppearTable(any, supplier);
  } else if (any.letterNodes) {
    animateAppearText(any, supplier);
  }
};

const textAndArrays = (root, anchor, ...elements) => {
  const result = [];
  const group = [];
  let previous = null;
  for (const element of elements) {
    if (isArray(element)) {
      const table = createTableComplete(element);
      result.push(table);
      if (previous) {
        if (previous.node) {
          rightof([table.table], [previous.node], root);
        } else if (previous.table) {
          rightof([table.table], [previous.table], root);
        }
        topleft([table.svg], [table.table], root);
      }
      group.push(table.table);
      group.push(table.svg);
    } else {
      const text = createText(element, root, { size: "normal" });
      result.push(text);
      if (previous) {
        if (previous.node) {
          rightof([text.node], [previous.node], root);
        } else if (previous.table) {
          rightof([text.node], [previous.table], root);
        }
      }
      group.push(text.node);
    }
    previous = result[result.length - 1];
  }
  belowleft(group, anchor, root);
  return { parts: result, group };
};

function* addNewLine(text, root, previousText) {
  const textn = createText(text, root, { size: "normal" });
  belowleft([textn.node], [previousText.node], root);
  yield (supplier) => centerOn([textn.node], root, supplier);
  yield (supplier) => animateAppearAny(textn, supplier);
  return textn;
}

function collectMainNodes(...elements) {
  const nodes = [];
  for (const e of elements) {
    if (e.node) {
      nodes.push(e.node);
    } else if (e.table) {
      nodes.push(e.table);
      nodes.push(e.svg);
    }
  }
  return nodes;
}

const adds = (structure, id, value) => {
  if (structure[id] !== undefined) {
    throw Error(id + " is already set");
  }
  structure[id] = value;
};

function* addNewLine(text, previousGroup, root) {
  const currentGroup = [
    createText(text, root, {
      size: "normal",
    }),
  ];
  if (previousGroup) {
    belowleft(
      collectMainNodes(...currentGroup),
      collectMainNodes(...previousGroup),
      root
    );
  }
  yield (supplier) =>
    centerOn(collectMainNodes(...currentGroup), root, supplier);
  for (const element of currentGroup) {
    yield (supplier) => animateAppearAny(element, supplier);
  }
  return { previousGroup, currentGroup };
}

function* animateAppearGroup(elements, root) {
  yield (supplier) => centerOn(collectMainNodes(...elements), root, supplier);
  for (const e of elements) {
    yield (supplier) => animateAppearAny(e, supplier);
  }
}

function* bablam(root, previousGroup) {
  const barResult = textAndArrays(
    root,
    collectMainNodes(...previousGroup),
    "Project managers use",
    ["skills", "applied knowledge"],
    "to satisfy",
    [
      "customers",
      "other people involved in the projects",
      "other people affected by the projects",
    ]
  );
  yield (supplier) => centerOn(barResult.group, root, supplier);
  for (const part of barResult.parts) {
    yield (supplier) => animateAppearAny(part, supplier);
  }
  const currentGroup = barResult.parts;
  console.log({ fn: "bablam", previousGroup, currentGroup });
  return { previousGroup, currentGroup };
}

function* biboum(root, previousGroup) {
  const table1 = createTableComplete(["leaders", "managers"]);
  const text2 = createText("apply", root, { size: "normal" });
  const table3 = createTableComplete([
    "practices",
    "principles",
    "processes",
    "tools",
    "techniques",
  ]);
  const text4 = createText("=> outcomes", root, { size: "normal" });
  const currentGroup = [table1, text2, table3, text4];

  topleft([table1.svg], [table1.table], root);
  rightof(collectMainNodes(text2), collectMainNodes(table1), root);
  rightof(collectMainNodes(table3), collectMainNodes(text2), root);
  topleft([table3.svg], [table3.table], root);
  rightof(collectMainNodes(text4), collectMainNodes(table3), root);
  belowleft(
    collectMainNodes(...currentGroup),
    collectMainNodes(...previousGroup),
    root
  );
  yield* animateAppearGroup([table1, text2, table3, text4], root);
  console.log({ fn: "biboum", previousGroup, currentGroup });
  return { previousGroup, currentGroup };
}

function* sequence() {
  const root = document.querySelector("#root");

  let previousGroup = null;
  let currentGroup = null;

  ({ currentGroup, previousGroup } = yield* addNewLine(
    "Project management ...",
    currentGroup,
    root
  ));

  ({ currentGroup, previousGroup } = yield* addNewLine(
    "...is not new",
    currentGroup,
    root
  ));

  ({ currentGroup, previousGroup } = yield* bablam(root, currentGroup));

  ({ currentGroup, previousGroup } = yield* biboum(root, currentGroup));

  ({ currentGroup, previousGroup } = yield* addNewLine(
    "Mid-20th century: seek recognition for project management as a profession",
    currentGroup,
    root
  ));

  ({ currentGroup, previousGroup } = yield* addNewLine(
    "Implied requirement: Agreement on the content of the project management body of knowledge",
    currentGroup,
    root
  ));

  ({ currentGroup, previousGroup } = yield* addNewLine(
    "PMI: Project Management Institute",
    currentGroup,
    root
  ));

  yield (supplier) => console.log("finished");
}

foo(sequence());
