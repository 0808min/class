import logo from './logo.svg';
import './App.css';
import Comment from './components/Comment';
<<<<<<< HEAD
import Notification from './components/Notification';
import Counter from './components/Counter';
import TextInputButton from './components/TextInputButton';
import Accommodate from './components/Acommodate';
import Toggle from './components/Toggle';
import MyButton from './components/MyButton';
import ConfirmButton from './components/ConfirmBUtton';
import Greeting from './components/Greeting';
import LoginControl from './components/LoginControl';
import MailBox from './components/MailBox';
import UserStatus from './components/UserStatus';
import WarningBanner from './components/WarnningBanner';
import MainPage from './components/Mainpage';


function App() {
  return (
    <MainPage />    
  );
}


{/* <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React 1234
        </a>
      </header>
    </div> */}

=======

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

>>>>>>> c019f3ff5bde4ea691c1d6f5d69c9e9bfe586b3a
export default App;
