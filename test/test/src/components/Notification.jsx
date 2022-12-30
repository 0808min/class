import React from "react";

class Notification extends React.Component{
    constructor(props) {
        super(props)
        this.state = {checkd : false}
    }

    componentDidMount() {
        const checkdVal = this.state.checkd
        console.log('componentDidMount() call', checkdVal)
        this.setState({checkd : true})
    }

    componentDidUpdate() {
        const checkdVal = this.state.checkd
        console.log('componentDidUpdate() call', checkdVal);
    }

    componentWillUnmount() {
        const checkdVal = this.state.checkd
        console.log('componentWillUnmount() call', checkdVal);
    }

    render() {
        return (
            <div>
                <span> {this.props.message}</span>
            </div>
        )
    }
}

export default Notification