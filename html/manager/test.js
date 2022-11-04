document.addEventListener('DOMContentLoaded', () => {
    const loginform = document.querySelector('#regForm')
    const userid = document.querySelector('#userID')
    const pw = document.querySelector('#pw')
    const repw = document.querySelector('#repw')
    const username = document.querySelector('#userName')


    document.addEventListener('submit', (event) => {

       

        const userid = document.querySelector('#userID')
        const pw = document.querySelector('#pw')
        const repw = document.querySelector('#repw')

        console.log(userid.value.search(/[a-zA-Z0-9]/))
        console.log(/[a-zA-Z0-9]/.test(userid.value))

        console.log(pw.value.search(/[a-zA-Z0-9]/))
        console.log(/[a-zA-Z0-9]/.test(pw.value))

        console.log(repw.value.search(/[a-zA-Z0-9]/))
        console.log(/[a-zA-Z0-9]/.test(repw.value))


        event.preventDefault()

        
    })

    document.addEventListener('click', (event) => {
            
    })

})

