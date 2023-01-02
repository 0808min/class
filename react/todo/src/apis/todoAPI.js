import axios from "axios";


export const postTodo = async (todo) => {
    // todo => {title:'', writer:'호날두', complete:false}
    const res = await axios.post('http://localhost/todos', todo)
    return res.data
}

// todo list
export const getTodoList = async () => {
    const res = await axios.get('http://localhost/todos')
    return res.data
}

export const getTodo = async (id) => {
    const res = await axios.get(`http://localhost/todos/${id}`)
    return res.data
}

export const deleteTodo = async (id) => {
    const res = await axios.delete(`http://localhost/todos/${id}`)
    return res.data
}

export const putTodo = async (todo) => {
    const res = await axios.put(`http://localhost/todos/${todo}`, todo)
    return res.data
}