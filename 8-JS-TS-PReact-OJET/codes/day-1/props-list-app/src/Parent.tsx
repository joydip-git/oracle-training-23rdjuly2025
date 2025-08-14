import { useState } from "react"
import Child from "./Child";

const Parent = () => {
    const [counter, setCounter] = useState(0);

    const counterHandler = () => {
        setCounter(
            (previous) => {
                return previous + 1
            }
        );
    }
    return (
        <div>
            <Child counterValue={counter} updater={counterHandler} />
        </div>
    )
}

export default Parent
/**
 * Child({counterValue:counter,updater:counterHandler})
 */