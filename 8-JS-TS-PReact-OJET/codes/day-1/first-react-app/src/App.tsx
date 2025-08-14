import { useState } from 'react';
import './App.css'
import Calculator from './Calculator';

function App() {
  //data
  const message = 'Welcome to React JS'
  //let sentence = 'React JS is a front-end UI development technique/library'

  const state = useState<string>('React JS is a front-end UI development technique/library');
  const data = state[0]; // current state value
  const updateData = state[1];

  //style
  const style = {
    backgroundColor: 'burlywood',
    fontFamily: 'Segoe UI'
  };

  //handlers
  const handleEdit = () => {
    //console.log(sentence);
    //sentence = "React JS promotes SPA";
    updateData("React JS promotes SPA");
    //console.log(sentence);
  };

  //design
  const div = (
    <div id='mainDiv'>
      <h1 id='mainHeader' style={style}>{message}</h1>
      <p id='mainPara'>
        {data}
      </p>
      <br />
      <button type="button" onClick={handleEdit}>Edit</button>
      <br />
      <Calculator />
    </div>
  )
  return div;
}

export default App
