
let replyList;
let editModal;

document.addEventListener('DOMContentLoaded', () => {

    // 댓글 리스트 출력 영역 캐스팅
    replyList = document.querySelector('#replyList')

    // 댓글 작성 버튼
    const btn_reply = document.querySelector("#btn_reply")
    // 댓글 수정 버튼
    const btn_edit = document.querySelector('#btn_edit')

    editModal = new bootstrap.Modal('#replyEditModal')


    // 버튼 이벤트 등록
    btn_reply.addEventListener('click', insertReply)
    btn_edit.addEventListener('click', editReply)

    // 페이지가 로드되면 리스트를 출력
    setList()


})

function setList(){

    // 비동기 통신 :댓글 리스트
    axios.get('/reply/'+bno)
    .then(res =>{

        console.log('response', res.data)

        let list = res.data;

        list.forEach((reply, index) => {
            // 새로운 tr을 만들어서 replyIndex 영역에 추가

            const newTR = document.createElement('tr')

            let html = '<td class="col-2">'+reply.replyer+'</td>'
            html += '<td class="col">'+reply.reply+'</td>'
            html += '<td class="col-2">'+reply.replydate+'</td>'
            html += '<td class="col-2"> ' +
                '<a href="javascript:showEditModal('+reply.rno+')" class="badge bg-warning text-decoration-none">수정</a> ' +
                '<a href="javascript:deleteReply('+reply.rno+')" class="badge bg-danger text-decoration-none">삭제</a> ' +
                '</td>'

            newTR.innerHTML=html  // $().html(html)
            newTR.setAttribute('class', 'fs-6 text-center')
            newTR.setAttribute('tr-index', reply.rno)

            // 부모 태그에 요소 추가
            replyList.appendChild(newTR)

        })
    })
    .catch(err => {
        console.log(err)
    })

}

function insertReply(){
    // 서버로 전송할 payload
    const payload = {
        bno : bno,
        reply : document.querySelector("#reply").value,
        replyer : document.querySelector("#replyer").value
    }

    console.log("payload", payload)

    axios.post('/reply', payload)
    .then(res => {

        console.log('post->response', res.data)

        const reply = res.data

        // replyList 영역에 새로운 tr을 추가

        const newTR = document.createElement('tr')

        let html = '<td class="col-2">'+reply.replyer+'</td>'
        html += '<td class="col">'+reply.reply+'</td>'
        html += '<td class="col-2">'+reply.replydate+'</td>'
        html += '<td class="col-2"> ' +
        '<a href="javascript:showEditModal('+reply.rno+')" class="badge bg-warning text-decoration-none">수정</a> ' +
        '<a href="javascript:deleteReply('+reply.rno+')" class="badge bg-danger text-decoration-none">삭제</a> ' +
        '</td>'

        newTR.innerHTML=html
        newTR.setAttribute('class', 'fs-6 text-center')
        newTR.setAttribute('tr-index', reply.rno)

        // 부모 태그에 요소 추가
        replyList.appendChild(newTR)

        document.querySelector("#reply").value=''
        document.querySelector("#replyer").value=''

    })
    .catch(err => console.log(err))
    }

function deleteReply(rno){

    if(!confirm('삭제하시겠습니까?')){
        return;
    }

    console.log('rno >>> ', rno)

    axios.delete('/reply/'+rno)
    .then( res => {

        console.log('delete - response => ', res.data)

        if( res.data == 1){
            // 화면에서 tr-index == rno 행을삭제
            // 삭제 대상 행
            const delTR = document.querySelector('tr[tr-index="'+rno+'"]')
            replyList.removeChild(delTR)
            alert('삭제되었습니다.')
        } else {
            alert('삭제할 대상이 존재하지 않습니다.')
        }

    })
        .catch(err => console.log(err))

}


function showEditModal(rno){

    editModal.show()

    const editTD = document.querySelectorAll('tr[tr-index="'+rno+'"]>td')

    //editTD[0].textContent='변경된 데이터'

    console.log(editTD[0].textContent)
    console.log(editTD[1].textContent)
    console.log(editTD[2].textContent)

    document.querySelector('#erno').value=rno
    document.querySelector('#ereplyer').value=editTD[0].textContent
    document.querySelector('#ereply').value=editTD[1].textContent
    document.querySelector('#ereplydate').value=editTD[2].textContent
}

function editReply(){
    // 서버로 전송할 payload
    // put => 전체 데이터의 변경, 모든 데이터를 서버로 전송, 값이 없는 경우 기본값으로 저장
    const payload = {
        bno : bno,
        rno : document.querySelector('#erno').value ,
        reply : document.querySelector("#ereply").value,
        replyer : document.querySelector("#ereplyer").value,
        replydate : document.querySelector('#ereplydate').value
    }

    console.log(payload)

    axios.put('/reply/'+payload.rno, payload)
    .then( res => {
        console.log('put -> response ',res.data)

        const editTD = document.querySelectorAll('tr[tr-index="'+payload.rno+'"]>td')
        editTD[1].textContent=payload.reply

        editModal.hide()

    })
    .catch(err => console.log(err))

}



