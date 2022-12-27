
// 함수형 컴포넌트 -> 엘리먼트 반환
function Mybutton(prop) {

    const[isClicked, setIsClicked] = React.useState(false)

    return React.createElement(
        'button',
        {onClick : () => isClicked ? setIsClicked(false) : setIsClicked(true)},
        isClicked ? '클릭한 상태' : '클릭하세요'
    )

}

const domContainer = document.querySelector('#root')
ReactDOM.render(React.createElement(Mybutton), domContainer)