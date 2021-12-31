import "./index.css";
const anime = window.anime;

const foo = (supplier) => {
  const actionfn = supplier.next().value;
  if (!actionfn) {
    return;
  }
  const action = actionfn(supplier);
  if (!action) {
    return;
  }
  action();
};

const createText = (ml, text, supplier) => {
  const h1 = document.createElement("h1");
  h1.setAttribute("class", ml);
  const span = document.createElement("span");
  span.setAttribute("class", "text-wrapper");
  const letters = document.createElement("span");
  letters.setAttribute("class", "letters");
  for (let i = 0; i < text.length; ++i) {
    const letter = document.createElement("span");
    letter.setAttribute("class", "letter");
    letter.style.opacity = 0;
    letter.appendChild(document.createTextNode(text[i]));
    letters.appendChild(letter);
  }
  span.appendChild(letters);
  h1.appendChild(span);
  document.getElementById("root").appendChild(h1);
  foo(supplier);
};

const animateAppear = (ml, supplier) => {
  anime
    .timeline({
      loop: false,
      duration: 10000,
    })
    .add({
      targets: "." + ml + " .letter",
      opacity: [0, 1],
      easing: "easeOutExpo",
      duration: 1,
      delay: (el, i) => 30 * (i + 1),
      complete: () => foo(supplier),
    });
};

const animateDisappear = (ml, supplier) => {
  anime
    .timeline({
      loop: false,
      duration: 10000,
    })
    .add({
      targets: "." + ml + " .letter",
      opacity: [1, 0],
      easing: "easeOutExpo",
      duration: 1,
      delay: (el, i) => 30 * (i + 1),
      complete: () => foo(supplier),
    });
};

const sleep = (duration, supplier) => {
  setTimeout(() => foo(supplier), duration);
};

const nextId = (() => {
  let id = 0;
  return () => ++id;
})();

function* sequence() {
  const ml1 = "ml" + nextId();
  const ml2 = "ml" + nextId();
  yield (supplier) => createText(ml1, "Project management ...", supplier);
  yield (supplier) => animateAppear(ml1, supplier);
  yield (supplier) => sleep(1000, supplier);
  yield (supplier) => animateDisappear(ml1, supplier);
  yield (supplier) => sleep(1000, supplier);
  yield (supplier) => createText(ml2, "...is not new", supplier);
  yield (supplier) => animateAppear(ml2, supplier);
  yield (supplier) => sleep(1000, supplier);
  yield (supplier) => animateDisappear(ml2, supplier);
  yield (supplier) => console.log("finished");
}
foo(sequence());
