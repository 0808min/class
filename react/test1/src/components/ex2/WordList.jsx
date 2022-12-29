import React from "react";

function WordList({words, removeWord}) {

    const list = words.map( (word, index) => {

        return(
            <li key={index}>
                {word}
                <button style={{marginLeft: 10}} onClick={() => removeWord(word)}>삭제</button> 
            </li>
        )
    })

    return (
        <ul>
            {list}
        </ul>
    )

}

export default WordList