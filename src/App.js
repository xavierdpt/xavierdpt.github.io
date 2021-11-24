import React from "react";
import "./App.css";

const directions = [
  [-1, 0], // right
  [0, 1], // down
  [1, 0], // left
  [0, -1], // up
];

const WHITE = 0;
const BLACK = 1;

const RIGHT = 0;
const DOWN = 1;
const LEFT = 2;
const UP = 3;

const initializeProgram = (instructions) =>
  Array.from({ length: instructions }, () => ({
    WHITE: undefined,
    BLACK: undefined,
  }));

const getDimensions = (gridSize) => ({
  width: gridSize * 2 + 1,
  height: gridSize * 2 + 1,
});

const initializeProgramState = (gridSize, numberOfOuterWalls) => {
  const { width, height } = getDimensions(gridSize);
  const grid = Array.from({ length: width }, () =>
    Array.from({ length: height }, () => ({ color: WHITE, pristine: true }))
  );
  for (let widx = 0; widx < numberOfOuterWalls; ++widx) {
    // north and south
    for (let x = 2 * widx; x < width - 2 * widx; ++x) {
      grid[x][2 * widx].color = BLACK;
      grid[x][height - 1 - 2 * widx].color = BLACK;
    }
    // east and west
    for (let y = 2 * widx; y < height - 2 * widx; ++y) {
      grid[2 * widx][y].color = BLACK;
      grid[width - 1 - 2 * widx][y].color = BLACK;
    }
  }
  return {
    instruction: 0,
    count: 0,
    x: gridSize + 1,
    y: gridSize + 1,
    grid,
  };
};

let actionChoices = [];
let currentActionChoice = null;

const initializePossibleActions = (instructions) => {
  const possibleActions = [];
  for (const direction of [RIGHT, DOWN, LEFT, UP]) {
    for (const color of [BLACK, WHITE]) {
      for (let instruction = 0; instruction < instructions; ++instruction) {
        possibleActions.push({ direction, color, instruction });
      }
    }
  }
  actionChoices = [];
  currentActionChoice = null;
  return possibleActions;
};

let program = null;
let programState = null;
let possibleActions = null;

const previousGrids = [];
const previousGridsColors = "123456789ABCDEF"
  .split("")
  .map((d) => `#${d}${d}${d}${d}${d}${d}`);

const INSTRUCTIONS_EXHAUSTED = "INSTRUCTIONS_EXHAUSTED";

const createAction = (random) => {
  if (random) {
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

const computeScore = (grid, count, width, height, maxInstructionCount) => {
  let score = 0;
  for (let x = 0; x < width; ++x) {
    for (let y = 0; y < height; ++y) {
      if (!grid[x][y].pristine) {
        ++score;
      }
    }
  }
  score += 1 - count / maxInstructionCount;
  return score;
};

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      intervalHandle: null,
      pauseHandle: null,
      instructions: 10,
      instructionsSteps: 1,
      maxInstructionCount: 10_000,
      pauseDuration: 1,
      gridSize: 150,
      cellSize: 2,
      generateRandomActions: true,
      numberOfOuterWalls: 15,
      context: null,
    };
  }
  start = () => {
    const {
      gridSize,
      instructions,
      instructionsSteps,
      numberOfOuterWalls,
      cellSize,
    } = this.state;

    const { width, height } = getDimensions(gridSize);
    program = initializeProgram(instructions);
    programState = initializeProgramState(gridSize, numberOfOuterWalls);
    possibleActions = initializePossibleActions(instructions);
    // draw initial grid

    const context = this.getContext();
    context.fillStyle = "black";
    for (let x = 0; x < width; ++x) {
      for (let y = 0; y < height; ++y) {
        if (programState.grid[x][y].color === BLACK) {
          context.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
        }
      }
    }
    // start interval
    this.setState({
      context,
      intervalHandle: setInterval(() => this.steps(instructionsSteps), 1),
    });
  };
  stop = (nextFn) => {
    const { intervalHandle, pauseHandle } = this.state;
    if (intervalHandle) {
      clearInterval(intervalHandle);
      this.setState({ intervalHandle: null }, nextFn);
    } else if (pauseHandle) {
      clearTimeout(pauseHandle);
      this.setState({ pauseHandle: null });
    }
  };
  steps = (nsteps) => {
    const { cellSize, pauseDuration, context } = this.state;
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
      context.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
    }
    if (stopped) {
      this.stop(() => {
        this.setState({
          pauseHandle: setTimeout(() => {
            this.setState({ pauseHande: null }, () => {
              this.nextProgram(instructionsExhausted);
              this.start();
            });
          }, pauseDuration),
        });
      });
    }
  };
  step = () => {
    const { generateRandomActions, gridSize, maxInstructionCount } = this.state;
    const { instruction, x, y, grid } = programState;
    const { width, height } = getDimensions(gridSize);
    debugger;
    let currentColor = grid[x][y].color;
    let action = program[instruction][currentColor];
    if (action === undefined) {
      action = createAction(generateRandomActions);
      program[instruction][currentColor] = action;
    }
    if (action === INSTRUCTIONS_EXHAUSTED) {
      return { stopped: true, cell: null, instructionsExhausted: true };
    }
    const nextX = x + directions[action.direction][0];
    const nextY = y + directions[action.direction][1];
    if (
      nextX < 0 ||
      nextX >= width ||
      nextY < 0 ||
      nextY >= height ||
      programState.count > maxInstructionCount
    ) {
      return { stopped: true, cell: null, instructionsExhausted: false };
    }
    const nextInstruction = action.instruction;
    const colorToWrite = action.color;
    grid[x][y].color = colorToWrite;
    grid[x][y].pristine = false;
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
    const {
      gridSize,
      cellSize,
      instructions,
      maxInstructionCount,
      numberOfOuterWalls,
      context,
    } = this.state;
    const { width, height } = getDimensions(gridSize);
    const previousGrid = programState.grid;
    const gridScore = computeScore(
      previousGrid,
      programState.count,
      width,
      height,
      maxInstructionCount
    );
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
      previousGrids.unshift({ grid: previousGrid, score: gridScore });
      previousGrids.sort((g1, g2) => {
        if (g1.score === g2.score) {
          return 0;
        } else {
          return g1.score < g2.score ? 1 : -1;
        }
      });
      if (previousGrids.length > previousGridsColors.length) {
        previousGrids.splice(previousGrids.length - 1);
      }
      console.log("High scores");
      console.group();
      const hexdigits = "123456789ABCDEF".split("");
      for (let gidx = 0; gidx < previousGrids.length; ++gidx) {
        console.log(`${hexdigits[gidx]} - ${previousGrids[gidx].score}`);
      }
      console.groupEnd();
    }
    context.fillStyle = "white";
    context.fillRect(0, 0, width * cellSize, height * cellSize);
    for (let gridIdx = previousGrids.length - 1; gridIdx >= 0; --gridIdx) {
      const grid = previousGrids[gridIdx].grid;
      const color = previousGridsColors[gridIdx];
      context.fillStyle = color;
      for (let x = 0; x < width; ++x) {
        for (let y = 0; y < height; ++y) {
          if (!grid[x][y].pristine) {
            context.fillRect(x * cellSize, y * cellSize, cellSize, cellSize);
          }
        }
      }
    }
    if (instructionsExhausted) {
      console.log(
        "Switching to program with " + (instructions + 1) + " instructions"
      );
      this.setState({ instructions: instructions + 1 }, () => {
        const { instructions, gridSize, numberOfOuterWalls } = this.state;
        possibleActions = initializePossibleActions(instructions);
        program = initializeProgram(instructions);
        programState = initializeProgramState(gridSize, numberOfOuterWalls);
        currentActionChoice = 0;
      });
    } else {
      program = initializeProgram(instructions);
      programState = initializeProgramState(gridSize, numberOfOuterWalls);
      currentActionChoice = 0;
    }
  };
  getContext() {
    const canvas = document.querySelector("#canvas");
    return canvas.getContext("2d");
  }
  render() {
    const {
      intervalHandle,
      pauseHandle,
      instructions,
      instructionsSteps,
      maxInstructionCount,
      pauseDuration,
      gridSize,
      cellSize,
      generateRandomActions,
      numberOfOuterWalls,
    } = this.state;
    const running = intervalHandle !== null || pauseHandle !== null;
    const { width, height } = getDimensions(gridSize);
    return (
      <div className="App">
        <div>
          <label htmlFor="instructions">Number of instructions</label>
          <input
            name="instructions"
            type="number"
            value={instructions}
            disabled={running}
            onChange={(e) =>
              this.setState({ instructions: Number(e.target.value) })
            }
          />
        </div>
        <div>
          <label htmlFor="maxInstructionCount">Max instruction count</label>
          <input
            name="maxInstructionCount"
            type="number"
            value={maxInstructionCount}
            disabled={running}
            onChange={(e) =>
              this.setState({ maxInstructionCount: Number(e.target.value) })
            }
          />
        </div>
        <div>
          <label htmlFor="instructionsSteps">Instructions per step</label>
          <input
            name="instructionsSteps"
            type="number"
            value={instructionsSteps}
            disabled={running}
            onChange={(e) =>
              this.setState({ instructionsSteps: Number(e.target.value) })
            }
          />
        </div>
        <div>
          <label htmlFor="pauseDuration">Pause between runs</label>
          <input
            name="pauseDuration"
            type="number"
            value={pauseDuration}
            disabled={running}
            onChange={(e) => this.setState({ pauseDuration: Number(e.target.value) })}
          />
        </div>
        <div>
          <label htmlFor="gridSize">Grid size</label>
          <input
            name="gridSize"
            type="number"
            value={gridSize}
            disabled={running}
            onChange={(e) => this.setState({ gridSize: Number(e.target.value) })}
          />
        </div>
        <div>
          <label htmlFor="cellSize">Cell size</label>
          <input
            name="cellSize"
            type="number"
            value={cellSize}
            disabled={running}
            onChange={(e) => this.setState({ cellSize: Number(e.target.value) })}
          />
        </div>
        <div>
          <input
            type="checkbox"
            name="generateRandomActions"
            checked={generateRandomActions}
            onChange={(e) =>
              this.setState({ generateRandomActions: e.target.checked })
            }
          />
          <label htmlFor="generateRandomActions">Generate random actions</label>
        </div>
        <div>
          <label htmlFor="numberOfOuterWalls">Number of outer walls</label>
          <input
            name="numberOfOuterWalls"
            type="number"
            value={numberOfOuterWalls}
            disabled={running}
            onChange={(e) =>
              this.setState({ numberOfOuterWalls: Number(e.target.value) })
            }
          />
        </div>
        <div>
          <button disabled={running} onClick={this.start}>
            Start
          </button>
          <button disabled={!running} onClick={() => this.stop()}>
            Stop
          </button>
          <button disabled={running} onClick={this.nextProgram}>
            Next
          </button>
        </div>
        <div>
          <canvas
            id="canvas"
            width={width * cellSize}
            height={height * cellSize}
          />
        </div>
      </div>
    );
  }
}

export default App;
