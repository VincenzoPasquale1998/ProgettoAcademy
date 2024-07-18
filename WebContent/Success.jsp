<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Tomorrow', sans-serif;
            height: 100vh;
            background-image: linear-gradient(to top, #2e1753, #1f1746, #131537, #0d1028, #050819);
            display: flex;
            justify-content: center;
            align-items: center;
            overflow: hidden;
        }

        .text {
            position: absolute;
            top: 10%;
            color: #fff;
            text-align: center;
        }

        h1 {
            font-size: 50px;
        }

        .cup img {
            width: 150px;
            position: absolute;
            top: 50%;
            animation: cupSpin 3s infinite linear;
        }

        @keyframes cupSpin {
            0% {
                transform: rotate(0deg);
            }
            100% {
                transform: rotate(360deg);
            }
        }

        .star {
            position: absolute;
            width: 2px;
            height: 2px;
            background: #fff;
            right: 0;
            animation: starTwinkle 3s infinite linear;
        }

        @keyframes starTwinkle {
            0% {
                background: rgba(255, 255, 255, 0.4);
            }
            25% {
                background: rgba(255, 255, 255, 0.8);
            }
            50% {
                background: rgba(255, 255, 255, 1);
            }
            75% {
                background: rgba(255, 255, 255, 0.8);
            }
            100% {
                background: rgba(255, 255, 255, 0.4);
            }
        }
    </style>
</head>
<body>
<div class="text">
    <div>Everything went well!</div>
    <h1>Success</h1>
    <hr>
    <div>Your operation was successful.</div>
</div>

<div class="cup">
    <img src="images/bg_3.jpg" alt="Cup">
</div>
</body>
</html>