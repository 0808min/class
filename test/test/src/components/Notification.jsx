import React from "react";

class Notification extends React.Component{
    constructor(props) {
        super(props)
        this.state = {}
    }

    componentDidMount() {
        console.log('componentDidMount() call')
    }

    componentDidUpdate() {
        console.log('componentDidUpdate() call');
    }

    componentWillUnmount() {
        console.log('componentWillUnmount() call');
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