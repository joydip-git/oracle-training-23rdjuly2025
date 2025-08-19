import { useContext, useState } from "react"
import DataContext from "./datacontext"
import Nested from "./Nested"

const Intermediate = () => {
    const { counter } = useContext(DataContext)
    const [numState, setNumState] = useState(counter * 2)

    const numHandler = () => {
        setNumState(
            (prev) => {
                return prev - 1
            }
        )
    }
    return (
        <DataContext.Provider value={{ counter: numState, counterHandler: numHandler }}>
            <div>
                Intermediate:
                <br />
                <Nested />
            </div>
        </DataContext.Provider>
    )
}

export default Intermediate