import "./index.css";
const anime = window.anime;
const debug = true;
const DEBUG_OPACITY = 0.3;

const u = (x, d) => (x === undefined || x === null ? d : x);

const mergeBoundingRects = (...elements) => {
  let first = true;
  let right = null;
  let top = null;
  let left = null;
  let bottom = null;
  for (const e of elements) {
    const r = e.getBoundingClientRect();
    if (first) {
      right = r.right;
      top = r.top;
      left = r.left;
      bottom = r.bottom;
    } else {
      right = r.right > right ? r.right : right;
      top = r.top < top ? r.top : top;
      left = r.left < left ? r.left : left;
      bottom = r.bottom > r.bottom ? r.bottom : bottom;
    }
    first = false;
  }
  return {
    right,
    top,
    left,
    bottom,
    width: right - left,
    height: bottom - top,
    x: left,
    y: top,
  };
};

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

const createText = (text, options = {}) => {
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
  document.getElementById("root").appendChild(h1);
  return { node: h1, letterNodes };
};

const animateAppear = (elements, supplier, options = {}) => {
  anime
    .timeline({
      loop: false,
      duration: 10000,
    })
    .add({
      targets: elements,
      opacity: [0, 1],
      easing: "easeOutExpo",
      duration: 1,
      delay: (el, i) =>
        u(options.elementDelay, 30) * (i + 1) + u(options.delay, 0),
      complete: () => foo(supplier),
    });
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
    duration: 200,
    complete: () => foo(supplier),
  });
};

const animatePath = (path, pathLength, supplier, options = {}) => {
  anime.timeline({ loop: false }).add({
    targets: path,
    strokeDashoffset: [pathLength, 0],
    easing: "linear",
    duration: u(options.duration, 1000),
    complete: () => foo(supplier),
  });
};

const sleep = (duration, supplier) => {
  setTimeout(() => foo(supplier), duration);
};

const pause = (supplier) => sleep(1000, supplier);

const center = (el, root) => {
  el.style.position = "absolute";
  el.style.left = Math.floor((root.offsetWidth - el.offsetWidth) / 2) + "px";
  el.style.top = Math.floor((root.offsetHeight - el.offsetHeight) / 2) + "px";
};

const below = (el1, el2, root) => {
  el2.style.position = "absolute";
  const r = el1.getBoundingClientRect();
  const rr = root.getBoundingClientRect();
  el2.style.left = r.x - rr.x + "px";
  el2.style.top = r.y - rr.y + "px";
};

const topleft = (target, anchor, root) => {
  const r = anchor.getBoundingClientRect();
  const rr = root.getBoundingClientRect();
  target.style.left = r.left - rr.x + "px";
  target.style.top = r.top - rr.y + "px";
};

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

const rightof = (target, anchor, root) => {
  const r = anchor.getBoundingClientRect();
  const t = target.getBoundingClientRect();
  const rr = root.getBoundingClientRect();
  target.style.position = "absolute";
  target.style.left = Math.floor(r.right - rr.x) + "px";
  target.style.top =
    Math.floor(r.top + r.height / 2 - t.height / 2 - rr.y) + "px";
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

const belowleft = (targets, anchors, root) => {
  const targetsRect = mergeBoundingRects(...targets);
  const anchorsRect = mergeBoundingRects(...anchors);
  const rr = root.getBoundingClientRect();
  const delta = {
    x: targetsRect.left - anchorsRect.left,
    y:
      -(targetsRect.top - anchorsRect.top) +
      anchorsRect.height +
      anchorsRect.height,
  };
  for (const t of targets) {
    const r = t.getBoundingClientRect();
    t.style.position = "absolute";
    t.style.top = Math.floor(r.top + delta.y - rr.x) + "px";
    t.style.left = Math.floor(r.left + delta.x - rr.y) + "px";
  }
};

function* sequence() {
  const root = document.querySelector("#root");

  const text1 = createText("Project management ...");
  yield (supplier) => centerOn([text1.node], root, supplier);
  yield (supplier) => animateAppear(text1.letterNodes, supplier);

  yield pause;
  const text2 = createText("...is not new");
  below(text1.node, text2.node, root);
  yield (supplier) => centerOn([text2.node], root, supplier);
  yield (supplier) => animateAppear(text2.letterNodes, supplier);
  yield pause;

  const table2 = createTableComplete(["leaders", "managers"]);
  topleft(table2.table, text2.node, root);
  topleft(table2.svg, table2.table, root);

  const text3 = createText("apply", { size: "normal" });
  rightof(text3.node, table2.table, root);

  const table = createTableComplete([
    "practices",
    "principles",
    "processes",
    "tools",
    "techniques",
  ]);
  rightof(table.table, text3.node, root);
  topleft(table.svg, table.table, root);

  const text4 = createText("=> outcomes", { size: "normal" });
  rightof(text4.node, table.table, root);

  const group1 = [
    table2.table,
    text3.node,
    table.table,
    text4.node,
    table2.svg,
    table.svg,
  ];
  belowleft(group1, [text2.node], root);
  yield (supplier) => centerOn(group1, root, supplier);
  yield (supplier) => animateAppearTable(table2, supplier);
  yield (supplier) => animateAppear(text3.letterNodes, supplier);
  yield (supplier) => animateAppearTable(table, supplier);
  yield (supplier) => animateAppear(text4.letterNodes, supplier);
  yield (supplier) => console.log("finished");
}
foo(sequence());
