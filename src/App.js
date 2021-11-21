import React from "react";
import "./App.css";

const WIDTH = 151;
const HEIGHT = 151;

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

const program = [{ WHITE: undefined, BLACK: undefined }];
let context = null;

const createRandomAction = () => {
  return {
    direction: Math.floor(Math.random() * 4),
    instruction: Math.floor(Math.random() * (program.length + 1)),
    color: Math.floor(Math.random() * 2),
  };
};
let intervalHandle = null;
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      instruction: 0,
      x: Math.floor(WIDTH / 2) + 1,
      y: Math.floor(HEIGHT / 2) + 1,
      grid: Array.from({ length: WIDTH }, () =>
        Array.from({ length: HEIGHT }, () => 0)
      ),
    };
  }
  drawOnCanvas = () => {
    const { instruction, x, y, grid } = this.state;
    const currentColor = grid[x][y];
    let action = program[instruction][currentColor];
    if (action === undefined) {
      action = createRandomAction();
      program[instruction][currentColor] = action;
      if (program[action.instruction] === undefined) {
        program.push({ [WHITE]: undefined, [BLACK]: undefined });
      }
    }
    const nextX = x + directions[action.direction][0];
    const nextY = y + directions[action.direction][1];
    if (nextX < 0 || nextX >= WIDTH || nextY < 0 || nextY >= HEIGHT) {
      clearInterval(intervalHandle);
      console.log("Stopped");
      return;
    }
    const nextInstruction = action.instruction;
    const colorToWrite = action.color;
    context.fillStyle = colorToWrite == WHITE ? "white" : "black";
    context.fillRect(x, y, 1, 1);
    grid[x][y] = action.color;
    console.log(JSON.stringify(program));
    this.setState({ x: nextX, y: nextY, instruction: nextInstruction });
  };
  componentDidMount() {
    const canvas = document.querySelector("#canvas");
    context = canvas.getContext("2d");
  }
  render() {
    return (
      <div className="App">
        <div>Welcome</div>
        <div>
          <canvas id="canvas" width={WIDTH} height={HEIGHT} />
        </div>
        <div>
          <button
            onClick={() => {
              intervalHandle = setInterval(this.drawOnCanvas, 100);
            }}
          >
            Draw canvas
          </button>
        </div>
      </div>
    );
  }
}

export default App;
