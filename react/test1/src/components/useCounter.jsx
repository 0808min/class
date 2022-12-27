import React from "react";
import { useState } from "react";

function useCounter(initVal){

    const [count, setCount] = useState(initVal)

    const incrementCount = () => setCount((count) => count + 1)

    const decrementCount = () => setCount((count) => Math.max(count - 1, 0))

    return [count, incrementCount, decrementCount]
    
}

export default useCounter