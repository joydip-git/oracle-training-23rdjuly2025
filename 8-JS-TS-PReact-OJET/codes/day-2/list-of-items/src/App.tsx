import { useState } from 'react';
import './App.css'

const names = ['anil', 'sunil', 'joydip'];

const App = () => {
  const [nameState, setNameState] = useState<string[]>(names);
  const nameHandler = (newName: string, index: number) => {
    setNameState(
      (prev) => {
        //spread operator 
        const copy = [...prev]
        copy.splice(index, 1, newName)
        return copy;
      }
    )
  }
  return (
    <div>
      <h2>Names: </h2>
      <ul>
        {
          nameState.map(
            (name, index) => {
              return <li>
                <label htmlFor="txtName">Name: &nbsp;</label>
                <input type="text" id='txtName' value={name}
                  onChange={
                    (e) => {
                      nameHandler(e.target.value, index);
                    }
                  } />
              </li>
            }
          )
        }
      </ul>
    </div>
  )
}

export default App