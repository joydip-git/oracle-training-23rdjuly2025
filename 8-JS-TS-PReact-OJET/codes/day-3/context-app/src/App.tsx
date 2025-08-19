import { useState } from 'react'
import './App.css'
import DataContext from './datacontext'
import Intermediate from './Intermediate'

function App() {
  const [numState, setNumState] = useState(1)

  const numHandler = () => {
    setNumState(
      (prev) => {
        return prev + 1
      }
    )
  }
  return (
    <DataContext.Provider value={
      { counter: numState, counterHandler: numHandler }
    }>
      <div>
        App:
        <br />
        <Intermediate />
      </div>
    </DataContext.Provider>
  )
}

export default App
