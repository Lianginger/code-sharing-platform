<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Create</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <h1 class="text-center m-5">Share Code in Real-time with Developers</h1>
            <div class="mb-3">
                <label for="time_restriction" class="form-label">Time Restriction</label>
                <input type="text" class="form-control" id="time_restriction">
            </div>
            <div class="mb-3">
                <label for="views_restriction" class="form-label">Views Restriction</label>
                <input type="text" class="form-control" id="views_restriction">
            </div>
            <div class="mb-3">
                <label for="code_snippet" class="form-label">Code</label>
                <textarea class="form-control" id="code_snippet" rows="3"></textarea>
            </div>
            <button id="send_snippet" type="submit" onclick="send()" type="button" class="btn btn-dark">Submit</button>
        </div>

        <script>
            function send() {
                let object = {
                    "code": document.getElementById("code_snippet").value,
                    "time": document.getElementById("time_restriction").value,
                    "views": document.getElementById("views_restriction").value
                };

                let json = JSON.stringify(object);

                let xhr = new XMLHttpRequest();
                xhr.open("POST", '/api/code/new', false)
                xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
                xhr.send(json);

                if (xhr.status == 200) {
                  alert("Success!");
                }
            }
        </script>
    </body>
</html>