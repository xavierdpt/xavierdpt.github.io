import React from "react";
import "./App.css";

const RANDOM = true;
const WIDTH = 601;
const HEIGHT = 601;
const CELL_SIZE = 1;

const directions = [
  [-1, 0], // right
  [0, 1], // down
  [1, 0], // left
  [0, -1], // up
];

const BLANK = 0;
const WHITE = 1;
const BLACK = 2;

const RIGHT = 0;
const DOWN = 1;
const LEFT = 2;
const UP = 3;

let INSTRUCTIONS = 100;
const MAX_INSTRUCTION_COUNT = 100000;
const PAUSE = 1;

const initializeProgram = () =>
  Array.from({ length: INSTRUCTIONS }, () => ({
    WHITE: undefined,
    BLACK: undefined,
  }));

const initializeProgramState = () => ({
  instruction: 0,
  count: 0,
  x: Math.floor(WIDTH / 2) + 1,
  y: Math.floor(HEIGHT / 2) + 1,
  grid: Array.from({ length: WIDTH }, () =>
    Array.from({ length: HEIGHT }, () => BLANK)
  ),
});

let actionChoices = [];
let currentActionChoice = null;

const initializePossibleActions = () => {
  const possibleActions = [];
  for (const direction of [RIGHT, DOWN, LEFT, UP]) {
    for (const color of [BLACK, WHITE]) {
      for (let instruction = 0; instruction < INSTRUCTIONS; ++instruction) {
        possibleActions.push({ direction, color, instruction });
      }
    }
  }
  actionChoices = [];
  currentActionChoice = null;
  return possibleActions;
};

let program = initializeProgram();
let programState = initializeProgramState();

let possibleActions = initializePossibleActions();

const previousGrids = [];
const previousGridsColors = "123456789ABCDEF"
  .split("")
  .map((d) => `#${d}${d}${d}${d}${d}${d}`);
let context = null;

const INSTRUCTIONS_EXHAUSTED = "INSTRUCTIONS_EXHAUSTED";

// This creates an action, reusing the choices done by the previous program
const createAction = () => {
  if (RANDOM) {
    const actionIndex = Math.floor(Math.random() * possibleActions.length);
    const action = possibleActions[actionIndex];
    return action;
  }
  // TODO: handle boundary when everything is maxxed
  if (currentActionChoice === null) {
    currentActionChoice = 0;
  }
  if (actionChoices[currentActionChoice] === undefined) {
    actionChoices.push(0);
  } else {
    // we increment this action choice only in all the next action choices are maxxed
    let maxxed = true;
    console.log(actionChoices);
    if (currentActionChoice < actionChoices.length - 1) {
      for (let i = currentActionChoice + 1; i < actionChoices.length; ++i) {
        if (actionChoices[i] !== possibleActions.length - 1) {
          maxxed = false;
        }
      }
    } else {
      if (actionChoices[currentActionChoice] !== possibleActions.length - 1) {
        maxxed = false;
      }
    }
    if (maxxed) {
      if (currentActionChoice === 0) {
        return INSTRUCTIONS_EXHAUSTED;
      } else {
        ++actionChoices[currentActionChoice];
        actionChoices.splice(currentActionChoice + 1);
      }
    } else {
      ++actionChoices[currentActionChoice];
    }
  }
  const action = possibleActions[actionChoices[currentActionChoice]];
  ++currentActionChoice;
  return action;
};

const computeScore = (grid, count) => {
  let score = 0;
  for (let x = 0; x < WIDTH; ++x) {
    for (let y = 0; y < HEIGHT; ++y) {
      if (grid[x][y] !== 0) {
        ++score;
      }
    }
  }
  score += 1 - count / MAX_INSTRUCTION_COUNT;
  return score;
};

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = { intervalHandle: null };
  }
  start = () => {
    this.setState({ intervalHandle: setInterval(() => this.steps(1000), 1) });
  };
  stop = (nextFn) => {
    const { intervalHandle } = this.state;
    clearInterval(intervalHandle);
    this.setState({ intervalHandle: null }, nextFn);
  };
  steps = (nsteps) => {
    let changedCells = {};
    let stopped = false;
    let instructionsExhausted = false;
    for (let i = 0; i < nsteps; ++i) {
      const stepResult = this.step();
      if (stepResult.cell) {
        changedCells[`${stepResult.cell.x}-${stepResult.cell.y}`] =
          stepResult.cell;
      }
      if (stepResult.stopped) {
        stopped = true;
        instructionsExhausted = stepResult.instructionsExhausted;
        break;
      }
    }
    for (const k in changedCells) {
      const x = changedCells[k].x;
      const y = changedCells[k].y;
      const colorToWrite = changedCells[k].colorToWrite;
      context.fillStyle = colorToWrite === BLACK ? "black" : "white";
      context.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }
    if (stopped) {
      this.stop(() => {
        setTimeout(() => {
          this.nextProgram(instructionsExhausted);
          this.start();
        }, PAUSE);
      });
    }
  };
  step = () => {
    const { instruction, x, y, grid } = programState;
    let currentColor = grid[x][y];
    if (currentColor === BLANK) {
      currentColor = WHITE;
    }
    let action = program[instruction][currentColor];
    if (action === undefined) {
      action = createAction();
      program[instruction][currentColor] = action;
    }
    if (action === INSTRUCTIONS_EXHAUSTED) {
      return { stopped: true, cell: null, instructionsExhausted: true };
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
      return { stopped: true, cell: null, instructionsExhausted: false };
    }
    const nextInstruction = action.instruction;
    const colorToWrite = action.color;
    grid[x][y] = action.color;
    programState.x = nextX;
    programState.y = nextY;
    programState.instruction = nextInstruction;
    ++programState.count;
    return {
      cell: { x, y, colorToWrite },
      stopped: false,
      instructionsExhausted: false,
    };
  };
  nextProgram = (instructionsExhausted) => {
    const previousGrid = programState.grid;
    const gridScore = computeScore(previousGrid, programState.count);
    let better = false;
    if (previousGrids.length === 0) {
      better = true;
    } else {
      for (const previousGrid of previousGrids) {
        if (previousGrid.score < gridScore) {
          better = true;
        }
      }
    }
    if (better) {
      console.log(JSON.stringify(program, null, 2));
      if (previousGrids.length === previousGridsColors.length) {
        previousGrids.splice(previousGrids.length - 1);
      }
      previousGrids.unshift({ grid: previousGrid, score: gridScore });
      console.log("High scores");
      console.group();
      const hexdigits = "123456789ABCDEF".split("");
      for (let gidx = 0; gidx < previousGrids.length; ++gidx) {
        console.log(`${hexdigits[gidx]} - ${previousGrids[gidx].score}`);
      }
      console.groupEnd();
    }
    context.fillStyle = "white";
    context.fillRect(0, 0, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
    for (let gridIdx = previousGrids.length - 1; gridIdx >= 0; --gridIdx) {
      const grid = previousGrids[gridIdx].grid;
      const color = previousGridsColors[gridIdx];
      context.fillStyle = color;
      for (let x = 0; x < WIDTH; ++x) {
        for (let y = 0; y < HEIGHT; ++y) {
          if (grid[x][y]) {
            context.fillRect(
              x * CELL_SIZE,
              y * CELL_SIZE,
              CELL_SIZE,
              CELL_SIZE
            );
          }
        }
      }
    }
    if (instructionsExhausted) {
      ++INSTRUCTIONS;
      console.log(
        "Switching to program with " + INSTRUCTIONS + " instructions"
      );
      possibleActions = initializePossibleActions();
    }

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
        <p>
          This is 2D Black and White Turing Machine simulator on a non-toroidal
          grid
        </p>
        <p>
          It randomly generates 2D Turing programs by choosing a random action
          among the possible actions every time the machine does not know what
          to do.
        </p>
        <p>Max number of instructions: {INSTRUCTIONS}</p>
        <p>Max computation horizon: {MAX_INSTRUCTION_COUNT}</p>
        <p>
          Score: number of cells written on the grid, and speed at which these
          cells were written in the fractional part
        </p>
        <p>
          The last best computation shadows are displayed in shades of gray.
        </p>
        <p>
          If you find a 2D Turing machine that grows in the center and gradually
          fills the space, without going to the infinite left, right, top or
          bottom, that would be a good one.
        </p>
        <p>Some info is dumped in the developer console</p>
        <div>
          <canvas
            id="canvas"
            width={WIDTH * CELL_SIZE}
            height={HEIGHT * CELL_SIZE}
          />
        </div>
        <div>
          <button disabled={!!intervalHandle} onClick={this.start}>
            Start
          </button>
          <button disabled={!intervalHandle} onClick={() => this.stop()}>
            Stop
          </button>
          <button disabled={!!intervalHandle} onClick={this.nextProgram}>
            Next
          </button>
        </div>
      </div>
    );
  }
}

export default App;
