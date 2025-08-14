import { useState } from "react"
import type { CalculationHistoryModel } from "./calculationhistorymodel";
import CalculationHistory from "./CalculationHistory";

const Calcultor = () => {
    const [radioState, setRadioState] = useState<number>(0);
    const [first, setFirst] = useState<number>(0);
    const [second, setSecond] = useState<number>(0);
    const [result, setResult] = useState<number>(0);
    const [history, setHistory] = useState<CalculationHistoryModel[]>([]);

    const historyHandler = (calculationType: string) => {
        setHistory(
            (old) => {
                return [
                    ...old,
                    {
                        type: calculationType,
                        resultValue: result,
                        firstValue: first,
                        secondValue: second
                    }
                ]
            }
        )
    }
    const calculate = () => {
        switch (radioState) {
            case 1:
                setResult(first + second)
                historyHandler('Addition')
                break;
            case 2:
                setResult(first - second)
                historyHandler('Subtraction')
                break;
            case 3:
                setResult(first * second)
                historyHandler('Multiplication')
                break;
            case 4:
                setResult(first / second)
                historyHandler('Division')
                break;
            default:
                setResult(0)
                break;
        }
    }

    return (
        <>
            <fieldset>
                <legend>Calculator</legend>
                <form>
                    <div>

                        <label htmlFor="radioAdd">Add:&nbsp;</label>
                        <input type="radio" id="radioAdd" name="operations" onChange={() => setRadioState(1)} />
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <label htmlFor="radioSubtract">Subtract:&nbsp;</label>
                        <input type="radio" id="radioSubtract" name="operations" onChange={() => setRadioState(2)} />
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <label htmlFor="radioMultiply">Multiply:&nbsp;</label>
                        <input type="radio" id="radioMultiply" name="operations" onChange={() => setRadioState(3)} />
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <label htmlFor="radioDivide">Divide:&nbsp;</label>
                        <input type="radio" id="radioDivide" name="operations" onChange={() => setRadioState(4)} />

                    </div>
                    <br />
                    <div>
                        <label htmlFor="txtFirst">First: &nbsp;</label>
                        <input type="text" id='txtFirst' value={first}
                            onChange={
                                (e) => {
                                    if (e.target.value !== '')
                                        setFirst(+e.target.value)
                                }
                            } />
                    </div>
                    <div>
                        <label htmlFor="txtSecond">Second: &nbsp;</label>
                        <input type="text" id='txtSecond' value={second}
                            onChange={
                                (e) => {
                                    if (e.target.value !== '')
                                        setSecond(+e.target.value)
                                }
                            } />
                    </div>
                    <div>
                        <input type="button" onClick={calculate} value="Calculate" />
                    </div>
                    <div>
                        <label htmlFor="txtResult">Result: &nbsp;</label>
                        <input type="text" id='txtResult' value={result} readOnly />
                    </div>
                </form>
            </fieldset>
            <br />

            <fieldset>
                <legend>Calculation History</legend>
                <div>
                    {
                        history.map(h => {
                            return <CalculationHistory history={h} key={h.resultValue} />
                        })
                    }
                </div>
            </fieldset>
        </>
    )
}

export default Calcultor