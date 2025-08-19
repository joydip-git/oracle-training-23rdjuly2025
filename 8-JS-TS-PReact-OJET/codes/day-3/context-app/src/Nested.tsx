import { useContext } from "react"
import DataContext from "./datacontext"

const Nested = () => {

    const { counter, counterHandler } = useContext(DataContext)
    return (
        <div>
            Nested:
            <br />
            Counter: &nbsp;{counter}
            <br />
            <button type="button" onClick={counterHandler}>Increase/Decrease</button>
        </div>
    )
}

export default Nested