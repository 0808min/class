import React from "react";

function NumberList(props) {

    const numbers = [11,42,23,34,85]

    // 배열의 map(callback 반환하는 값) = 새로운 배열을 만들어준다
    const listItems = numbers.map((number) => <li> {number}</li>)
    
    // [{},{},{},{},{}]

    return (
        <ul>
            {listItems}
        </ul>
    )
}

export default NumberList