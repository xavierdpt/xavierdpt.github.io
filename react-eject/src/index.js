import "./index.css";
const anime = window.anime;

const foo = (next) => {
  const actionfn = next.next().value;
  if (!actionfn) {
    return;
  }
  const action = actionfn();
  if (!action) {
    return;
  }
  if (action.action === "log") {
    console.log(action.text);
  } else if (action.action === "animate") {
    const { ml, text } = action;
    const h1 = document.createElement("h1");
    h1.setAttribute("class", ml);
    const span = document.createElement("span");
    span.setAttribute("class", "text-wrapper");
    const letters = document.createElement("span");
    letters.setAttribute("class", "letters");
    for (let i = 0; i < text.length; ++i) {
      const letter = document.createElement("span");
      letter.setAttribute("class", "letter");
      letter.appendChild(document.createTextNode(text[i]));
      letters.appendChild(letter);
    }
    span.appendChild(letters);
    h1.appendChild(span);
    document.getElementById("root").appendChild(h1);

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
      })
      .add({
        duration: 1000,
        targets: "body",
        opacity: [1, 1],
      })
      .add({
        targets: "." + ml + " .letter",
        opacity: [1, 0],
        easing: "easeOutExpo",
        duration: 1,
        delay: (el, i) => 30 * (i + 1),
        complete: () => foo(next),
      });
  }
};

const idGenerator = (() => {
  let id = 0;
  return () => ++id;
})();

function* sequence() {
  yield () => ({
    action: "animate",
    text: "Project management ...",
    ml: "ml" + idGenerator(),
  });
  yield () => ({
    action: "animate",
    text: "...is not new",
    ml: "ml" + idGenerator(),
  });
  yield () => ({ action: "log", text: "finished" });
}
foo(sequence());
