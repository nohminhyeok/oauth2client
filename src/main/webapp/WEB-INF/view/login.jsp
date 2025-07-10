<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Social Login</title>
<style>
body {
    background: linear-gradient(135deg, #292c36 0%, #3b414c 100%);
    font-family: 'SUIT', 'Pretendard', 'Noto Sans KR', 'Malgun Gothic', Arial, sans-serif;
    min-height: 100vh;
    margin: 0;
    display: flex;
    align-items: center;
    justify-content: center;
}
.social-container {
    background: rgba(255,255,255,0.06);
    box-shadow: 0 6px 32px 0 rgba(0,0,0,0.3);
    border-radius: 2.5rem;
    padding: 3rem 3.5rem 2.5rem 3.5rem;
    text-align: center;
    min-width: 330px;
    border: 1.5px solid rgba(200,255,255,0.18);
    backdrop-filter: blur(12px);
}

.social-title {
    font-size: 2.1rem;
    color: #fff;
    margin-bottom: 2.5rem;
    font-weight: 800;
    letter-spacing: 0.03em;
    text-shadow: 0 3px 20px #2228;
}

.social-btn {
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 0.8rem;
    margin-bottom: 1.2rem;
    width: 100%;
    padding: 1rem 0;
    border-radius: 2rem;
    border: none;
    font-size: 1.1rem;
    font-weight: 700;
    cursor: pointer;
    box-shadow: 0 3px 16px 0 rgba(0,0,0,0.16), 0 2px 8px 0 rgba(0,0,0,0.11);
    transition: transform 0.12s, box-shadow 0.12s;
    outline: none;
    background: #444;
    color: #fff;
    text-decoration: none;
    position: relative;
    z-index: 1;
    letter-spacing: 0.01em;
}
.social-btn:hover {
    transform: scale(1.045);
    box-shadow: 0 8px 24px 0 rgba(0,0,0,0.23);
}
.social-btn.facebook {
    background: linear-gradient(90deg,#4267B2 0%, #294a94 100%);
}
.social-btn.facebook:hover { background: #345089; }
.social-btn.google {
    background: linear-gradient(90deg,#fff 0%, #f8f8f8 100%);
    color: #24292f;
    border: 1.5px solid #dadce0;
}
.social-btn.google:hover { background: #ececec; }
.social-btn.naver {
    background: linear-gradient(90deg,#2db400 0%, #1fa300 100%);
    color: #fff;
}
.social-btn.naver:hover { background: #219d00; }
.social-btn.kakao {
    background: linear-gradient(90deg,#FEE500 0%, #ffe357 100%);
    color: #3d1e1e;
    border: 1.5px solid #d6c500;
}
.social-btn.kakao:hover { background: #f6dc00; }
.social-btn .icon {
    width: 1.5rem;
    height: 1.5rem;
    vertical-align: middle;
    display: inline-block;
}
@media (max-width: 600px) {
    .social-container { min-width: 90vw; padding: 1.5rem; }
    .social-title { font-size: 1.4rem; }
}
</style>
</head>
<body>
    <div class="social-container">
        <div class="social-title">소셜 로그인</div>
        <a href="/oauth2/authorization/facebook" class="social-btn facebook">
            <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/facebook/facebook-original.svg" class="icon" alt="Facebook" />
            Facebook 로그인
        </a>
        <a href="/oauth2/authorization/google" class="social-btn google">
            <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/google/google-original.svg" class="icon" alt="Google" />
            Google 로그인
        </a>
		<a href="/oauth2/authorization/naver" class="social-btn naver" style="display:flex;align-items:center;justify-content:center;gap:0.7rem;">
		    <span style="display:inline-block;width:1.5rem;height:1.5rem;background:#fff;border-radius:0.3rem;font-weight:900;font-size:1.23rem;color:#19ce60;line-height:1.5rem;text-align:center;box-shadow:0 1px 6px #0002;">
		        N
		    </span>
		    <span style="font-size:1.2rem;font-weight:900;letter-spacing:0.01em;">네이버 로그인</span>
		</a>
        <a href="/oauth2/authorization/kakao" class="social-btn kakao">
            <img src="https://cdn.jsdelivr.net/gh/simple-icons/simple-icons/icons/kakaotalk.svg" class="icon" alt="Kakao" />
            Kakao 로그인
        </a>
    </div>
</body>
</html>
