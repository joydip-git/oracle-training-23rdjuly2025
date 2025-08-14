type ChildPropsType = {
    counterValue: number,
    updater: () => void
}
const Child = ({ counterValue, updater }: ChildPropsType) => {
    //const { counterValue, updater } = props
    // const counterValue = props.counterValue
    // const updater = props.updater
    return (
        <div>
            Counter:&nbsp;{counterValue}
            < br />
            <button type="button" onClick={updater}>Increase</button>
        </div>
    )
}

export default Child