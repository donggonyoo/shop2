<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AI챗봇</title>
    <link rel="stylesheet" href="/css/chatbot.css">
</head>

<body>
    <div id="chatbotarea" class="text-center rounded" style="background-color: #1aaaa1;">
        <label for="gptarea" class="text-light fw-bold">AI챗봇</label>
        <div id="gptAnswerArea" class="chatbot" style="background-color: #A8C0D6;">
            <div class="chat bot">
                <div class="icon"><i></i></div>
                <div class="textbox text-start">AI챗봇입니다 궁금한 점 문의해주세요</div>
            </div>
        </div>
    </div>
    <hr>
    <div id="gptarea"><textarea id="gpt_question" rows="2" class="form-control"></textarea></div>
    <div class="text-end d-flex justify-content-between">
        <button class="btn btn-primary text-light" onclick="gptquestion()">AI 문의</button>
    </div><br>
    <script>
        let gpt_question = document.querySelector("#gpt_question")
        gpt_question.addEventListener("keydown",(e)=>{
            if(e.keyCode == 13){ //enter
                gptquestion();
            }
        })

        function gptquestion(){
            let gpt_question = document.querySelector("#gpt_question").value
            if(gpt_question == ''){
                alert("AI챗봇에게 질문할 내용입력해주세요");
                document.querySelector("#gpt_question").focus();
                return;
            }
            if(gpt_question.length < 10){
                alert("질문할 내용을 조금 더 자세히 하세요");
                document.querySelector("#gpt_question").focus();
                return;
            }
            let html = "<div class='chat me'><div class='icon'><i></i></div>"
            html += "<div class='textbox'>"+gpt_question+"</div></div>"
            document.querySelector("#gptAnswerArea").innerHTML += html;
            document.querySelector("#gpt_question").value = "";
            let gptAnswerArea = document.querySelector("#gptAnswerArea")
            gptAnswerArea.scrollTop = gptAnswerArea.scrollHeight

            paramdata = {
                method : "POST",
                headers : {"Content-Type":"application/x-www-form-urlencoded;charset=UTF-8"},
                referrerPolicy : "no-referrer",
                body : "question="+gpt_question
            }
            fetch('/ajax/gptquestion',paramdata)
            .then(response=>response.text())
            .then(gptdata=>{
                let html = "<div class='chat bot'><div class='icon'><i></i></div>"
                html+="<div class='textbox'>"+gptdata.replaceAll("\n","<br>").replaceAll(" ","&nbsp;")+"</div></div></div>"
                    document.querySelector("#gptAnswerArea").innerHTML += html;
                    let gptAnswerArea = document.querySelector("#gptAnswerArea")
                    gptAnswerArea.scrollTop = gptAnswerArea.scrollHeight
            })
        }
    </script>
</body>

</html>