import type { CalculationHistoryModel } from "./calculationhistorymodel"

type CalculationHistoryPropsType = {
    history: CalculationHistoryModel
}
const CalculationHistory = (props: CalculationHistoryPropsType) => {

    const { type, firstValue, secondValue, resultValue } = props.history
    return (
        <li>
            {type} of {firstValue} and {secondValue} is {resultValue}
        </li>
    )
}

export default CalculationHistory