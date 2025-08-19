import { createContext } from "react";

type ContextDataType = {
    counter: number,
    counterHandler: () => void
}
//const DataContext = createContext<number>(0)
const DataContext = createContext<ContextDataType>({
    counter: 0,
    counterHandler: () => { }
})
export default DataContext