import MutableArrayDataProvider = require("ojs/ojmutablearraydataprovider")
import { useState } from "preact/hooks"

const NameList = () => {
    //const [names, setNames] = useState(['anil', 'sunil', 'joydip'])
    const dataProvider = new MutableArrayDataProvider<>();
    return (
        <div>

        </div>
    )
    // return (
    //     <div>
    //         <h3>List of Names</h3>
    //         <ul>
    //             {
    //                 names.map(
    //                     (name) => (<li key={name}>{name}</li>)
    //                 )
    //             }
    //         </ul>
    //     </div>
    // )
}

export default NameList