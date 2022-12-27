import logo from './logo.svg';
import './App.css';
import Comment from './components/Comment';

const comment = {
  user : {
    userName : '손흥민',
    imgUrl : 'https://flexible.img.hani.co.kr/flexible/normal/900/609/imgdb/original/2022/0918/20220918500360.jpg'
  },
  content : '대한민국 화이팅',
  replydate : '2022-12-27'
}

function App() {
  return (
   <Comment user={comment.user} content={comment.content} replydate={comment.replydate}/>
  );
}

export default App;
