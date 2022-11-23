import React, { useEffect, useReducer, useState } from "react";
import { Link } from "react-router-dom";
// import * as mdef from "../library/myDefine"; 로컬스토리지 이용
import "../css/Login.css";
import "../css/Navbar.css";

const LS_KEY_ID = "LS_KEY_ID";
const LS_KEY_SAVE_ID_FLAG = "LS_KEY_SAVE_ID_FLAG";

function inputReducer(state, action) {
  return {
    ...state,
    [action.id]: action.value,
  };
}

const Login = () => {
  const [state, dispatch] = useReducer(inputReducer, {
    loginID: "",
    loginPassword: "",
  });
  const { loginID, loginPassword } = state;

  const [saveIDFlag, setSaveIDFlag] = useState(false);
  const [passwordOption, setPasswordOption] = useState(false);
  const [passwordInputType, setPasswordInputType] = useState({
    type: "password",
    autoComplete: "current-password",
  });
  const [capsLockFlag, setCapsLockFlag] = useState(false);

  const checkCapsLock = (e) => {
    let capsLock = e.getModifierState("CapsLock");
    setCapsLockFlag(capsLock);
  };

  const dataRuleCheckForID = (ch) => {
    let ascii = ch.charCodeAt(0);
    if (48 /* 0 */ <= ascii && ascii <= 57 /* 9 */) return true;
    if (65 /* A */ <= ascii && ascii <= 90 /* Z */) return true;
    if (97 /* a */ <= ascii && ascii <= 122 /* z */) return true;
    if (ch === ".") return true;

    return false;
  };

  const getLoginID = (event) => {
    let value = event.target.value;

    if (value === "") {
      dispatch(event.target);
      return;
    }

    let length = value.length;
    if (dataRuleCheckForID(value[length - 1]) === false) return;

    dispatch(event.target);

    return;
  };

  const handleSaveIDFlag = () => {
    localStorage.setItem(LS_KEY_SAVE_ID_FLAG, !saveIDFlag);
    setSaveIDFlag(!saveIDFlag);
  };

  const login = () => {
    console.log({ loginID, loginPassword });

    if (loginID === "") {
      alert("아이디를 입력해주세요.");
      return;
    }

    if (loginPassword === "") {
      alert("비밀번호를 입력해주세요.");
      return;
    }

    if (true /* login fail */) {
      alert("아이디 혹은 패스워드가 틀립니다.");
      dispatch({ id: "loginID", value: "" });
      dispatch({ id: "loginPassword", value: "" });
      localStorage.setItem(LS_KEY_ID, "");

      return;
    }
    //로컬스토리지
    if (true /* login success */) {
      if (saveIDFlag) localStorage.setItem(LS_KEY_ID, loginID);
    }
  };

  useEffect(() => {
    //document.title = mdef.CURRENT_CORP.DOCUMENT_TITLE_LOGIN; 로컬스토리지 이용

    let idFlag = JSON.parse(localStorage.getItem(LS_KEY_SAVE_ID_FLAG));
    if (idFlag !== null) setSaveIDFlag(idFlag);
    if (idFlag === false) localStorage.setItem(LS_KEY_ID, "");

    let data = localStorage.getItem(LS_KEY_ID);
    if (data !== null) dispatch({ id: "loginID", value: data });
  }, []);

  useEffect(() => {
    if (passwordOption === false)
      setPasswordInputType({
        type: "password",
        autoComplete: "current-password",
      });
    else
      setPasswordInputType({
        type: "text",
        autoComplete: "off",
      });
  }, [passwordOption]);

  return (
    <div className='login-form'>
      <div className='login-wrapper'>
        <div className='login-container'>
          <div className='login-logo'>
            <img className='logo-image' alt='e4' src='img/e4.png' />
          </div>
          <form id='loginForm'>
            <div className='input-group' style={{ "vertical-align": "middle" }}>
              <input type='text' id='loginID' name='email' placeholder='아이디' className='input-id' onKeyDown={(e) => checkCapsLock(e)} value={loginID} onChange={(e) => getLoginID(e)} />
              <input
                type={passwordInputType.type}
                id='loginPassword'
                name='password'
                placeholder='비밀번호'
                className='input-pw'
                autoComplete={passwordInputType.autoComplete}
                onKeyDown={(e) => checkCapsLock(e)}
                value={loginPassword}
                onChange={(e) => dispatch(e.target)}
              />
            </div>
            <div className='checkbox-wrapper'>
              <span className='checkbox-item'>
                <input type='checkbox' name='saveEmail' id='saveEmail' checked={saveIDFlag} onChange={handleSaveIDFlag} />
                <label>
                  <span>아이디 저장</span>
                </label>
              </span>
              <span className='checkbox-item'>
                <input type='checkbox' checked={passwordOption} onChange={() => setPasswordOption(!passwordOption)} />
                <label>
                  <span>비밀번호 표시</span>
                </label>
              </span>

              <span className={capsLockFlag ? "caps-lock caps-lock-on" : "caps-lock"}>{capsLockFlag ? "Caps Lock On" : "Caps Lock Off"}</span>
            </div>
            <Link to='/payhome'>
              <span className='login-button' onClick={login}>
                로그인
              </span>
            </Link>
          </form>
          <ul className='login-li-group'>
            <li>
              <span onClick={() => alert("잘 기억해보세요.")}>아이디 찾기</span>
            </li>
            <li>
              <span onClick={() => alert("잘 기억해보세요.")}>비밀번호 찾기</span>
            </li>
            <li>
              <Link to='/Signup'>
                <span className='bold'>회원가입</span>
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </div>
  );
};

export default Login;
