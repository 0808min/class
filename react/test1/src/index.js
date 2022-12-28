import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Team from './components/PlayerList';
import ConfirmDialog from './components/ConfirmDialog';
import Clock from './components/Clock';

const root = ReactDOM.createRoot(document.getElementById('root'));

/* function tick(){
  root.render(
    <React.StrictMode>
      <Clock />
    </React.StrictMode>
  ); 
}

setInterval(tick, 1000); */

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
); 

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
