import React from "react";
import "./App.css";

const WIDTH = 401;
const HEIGHT = 401;
const CELL_SIZE = 2;

const directions = [
  [-1, 0], // right
  [0, 1], // down
  [-1, 0], // left
  [0, -1], // up
];

const WHITE = 0;
const BLACK = 1;

const RIGHT = 0;
const DOWN = 1;
const LEFT = 2;
const UP = 3;

const INSTRUCTIONS = 5;
const MAX_INSTRUCTION_COUNT = 1000;

const initializeProgram = () =>
  Array.from(Array({ length: INSTRUCTIONS }), () => ({
    WHITE: undefined,
    BLACK: undefined,
  }));

const initializeProgramState = () => ({
  instruction: 0,
  count: 0,
  x: Math.floor(WIDTH / 2) + 1,
  y: Math.floor(HEIGHT / 2) + 1,
  grid: Array.from({ length: WIDTH }, () =>
    Array.from({ length: HEIGHT }, () => 0)
  ),
});

let program = initializeProgram();
let programState = initializeProgramState();

const possibleActions = [];
for (const direction of [RIGHT, DOWN, LEFT, UP]) {
  for (const color of [BLACK, WHITE]) {
    for (let instruction = 0; instruction < INSTRUCTIONS; ++instruction) {
      possibleActions.push({ direction, color, instruction });
    }
  }
}
const actionChoices = [];
let currentActionChoice = null;

let context = null;

// This creates an action, reusing the choices done by the previous program
const createAction = () => {
  // TODO: handle boundary when everything is maxxed
  if (currentActionChoice === null) {
    currentActionChoice = 0;
  }
  if (actionChoices[currentActionChoice] === undefined) {
    actionChoices.push(0);
  } else {
    // we increment this action choice only in all the next action choices are maxxed
    let maxxed = true;
    for (let i = currentActionChoice + 1; i < actionChoices.length; ++i) {
      if (actionChoices[i] !== possibleActions.length - 1) {
        maxxed = false;
      }
    }
    if (maxxed) {
      ++actionChoices[currentActionChoice];
      actionChoices.splice(currentActionChoice + 1);
    }
  }
  const action = possibleActions[actionChoices[currentActionChoice]];
  ++currentActionChoice;
  return action;
};

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { intervalHandle: null };
  }
  start = () => {
    this.setState({ intervalHandle: setInterval(this.step, 1) });
  };
  stop = (nextFn) => {
    const { intervalHandle } = this.state;
    clearInterval(intervalHandle);
    this.setState({ intervalHandle: null }, nextFn);
  };
  step = () => {
    const { instruction, x, y, grid } = programState;
    const currentColor = grid[x][y];
    let reRender = false;
    let action = program[instruction][currentColor];
    if (action === undefined) {
      action = createAction();
      program[instruction][currentColor] = action;
      if (program[action.instruction] === undefined) {
        program.push({ [WHITE]: undefined, [BLACK]: undefined });
      }
      reRender = true;
    }
    const nextX = x + directions[action.direction][0];
    const nextY = y + directions[action.direction][1];
    if (
      nextX < 0 ||
      nextX >= WIDTH ||
      nextY < 0 ||
      nextY >= HEIGHT ||
      programState.count > MAX_INSTRUCTION_COUNT
    ) {
      console.log("Stop (" + programState.count + ")");
      this.stop(() => {
        this.nextProgram();
        this.start();
      });
      return;
    }
    const nextInstruction = action.instruction;
    const colorToWrite = action.color;
    context.fillStyle = colorToWrite === WHITE ? "white" : "black";
    context.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    grid[x][y] = action.color;
    programState.x = nextX;
    programState.y = nextY;
    programState.instruction = nextInstruction;
    ++programState.count;
    if (reRender) {
      this.forceUpdate();
    }
  };
  nextProgram = () => {
    console.log("Next");
    context.fillStyle = "white";
    context.fillRect(0, 0, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
    program = initializeProgram();
    programState = initializeProgramState();
    currentActionChoice = 0;
  };
  componentDidMount() {
    const canvas = document.querySelector("#canvas");
    context = canvas.getContext("2d");
  }
  render() {
    const { intervalHandle } = this.state;
    return (
      <div className="App">
        <div>Welcome</div>
        <div>
          <canvas
            id="canvas"
            width={WIDTH * CELL_SIZE}
            height={HEIGHT * CELL_SIZE}
          />
        </div>
        <div>
          <button disabled={!!intervalHandle} onClick={this.start}>
            Draw canvas
          </button>
          <button disabled={!intervalHandle} onClick={() => this.stop()}>
            Stop
          </button>
          <button disabled={!!intervalHandle} onClick={this.nextProgram}>
            Next
          </button>
          <pre>{JSON.stringify({ program, actionChoices }, null, 2)}</pre>
        </div>
      </div>
    );
  }
}

export default App;
