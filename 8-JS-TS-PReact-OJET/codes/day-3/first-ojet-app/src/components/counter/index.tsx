import { h } from 'preact'
import { useState } from 'preact/hooks'
//import 'ojs/ojbutton'
import 'ojs/ojlabel'
import 'ojs/ojinputtext'
import { ojInputText } from "ojinputtext";

const Counter = () => {

    const [counter, setCounter] = useState(0)
    const counterHandler = (val: number) => {
        setCounter(
            (old) => (old + val)
        )
    }
    return (
        <div>
            Counter:{counter}
            <br />
            <oj-label>Enter Counter:&nbsp;</oj-label>
            <oj-input-text onvalueChanged={
                (e) => {
                    const input = e.target as ojInputText;
                    if (input.value != '') {
                        counterHandler(Number(input.value))
                    }
                }
            }></oj-input-text>
            {/* <oj-button onClick={() => setCounter((old) => (old + 1))}>Increase</oj-button> */}
        </div>
    )
}

export default Counter