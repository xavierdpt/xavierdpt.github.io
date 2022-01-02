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
      bottom = r.bottom > bottom ? r.bottom : bottom;
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

const center = (targets, anchors, root) => {
  const tr = mergeBoundingRects(...targets);
  const ar = mergeBoundingRects(...anchors);
  const rr = root.getBoundingClientRect();
  const tc = { x: tr.x + tr.width / 2, y: tr.y + tr.height / 2 };
  const ac = { x: ar.x + ar.width / 2, y: ar.y + ar.height / 2 };
  const d = { x: ac.x - tc.x, y: ac.y - tc.y };
  for (const t of targets) {
    const r = t.getBoundingClientRect();
    t.style.left = Math.floor(r.x + d.x - rr.x) + "px";
    t.style.top = Math.floor(r.y + d.y - rr.y) + "px";
  }
};

const belowleft = (targets, anchors, root) => {
  const tr = mergeBoundingRects(...targets);
  const ar = mergeBoundingRects(...anchors);
  const rr = root.getBoundingClientRect();
  const d = { x: ar.x - tr.x, y: ar.y + ar.height - tr.y };
  for (const t of targets) {
    const r = t.getBoundingClientRect();
    t.style.left = Math.floor(r.x + d.x - rr.x) + "px";
    t.style.top = Math.floor(r.y + d.y - rr.y) + "px";
  }
};

const rightof = (targets, anchors, root) => {
  const tr = mergeBoundingRects(...targets);
  const ar = mergeBoundingRects(...anchors);
  const rr = root.getBoundingClientRect();
  const tc = { x: tr.x + tr.width / 2, y: tr.y + tr.height / 2 };
  const ac = { x: ar.x + ar.width / 2, y: ar.y + ar.height / 2 };
  const d = { x: ar.x + ar.width - tr.x, y: ac.y - tc.y };
  for (const t of targets) {
    const r = t.getBoundingClientRect();
    t.style.left = Math.floor(r.x + d.x - rr.x) + "px";
    t.style.top = Math.floor(r.y + d.y - rr.y) + "px";
  }
};

const topleft = (targets, anchors, root) => {
  const tr = mergeBoundingRects(...targets);
  const ar = mergeBoundingRects(...anchors);
  const rr = root.getBoundingClientRect();
  const d = { x: ar.x - tr.x, y: ar.y - tr.y };
  for (const t of targets) {
    const r = t.getBoundingClientRect();
    t.style.left = Math.floor(r.x + d.x - rr.x) + "px";
    t.style.top = Math.floor(r.y + d.y - rr.y) + "px";
  }
};
export { mergeBoundingRects, center, belowleft, rightof, topleft };
