<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Latest</title>
        <link rel="stylesheet"
              target="_blank" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
        <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
    </head>
    <body>
        <h1>Share Code in Real-time with Developers</h1>
        <#list latestCodeShare as codeShare>
        <span id="load_date">${codeShare.date}</span>
            <pre id="code_snippet">
                <code>
                    ${codeShare.code}
                </code>
            </pre>
        </#list>
    </body>
</html>