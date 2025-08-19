import './app.css'
import { useState } from "preact/hooks";

export function App() {
  const [counter, setCounter] = useState(0)
  return (
    <>
      <div>
        Counter: {counter}
        <br />
        <button type="button" onClick={() => setCounter((old) => (old + 1))}>Increase</button>
      </div>
    </>
  )
}
