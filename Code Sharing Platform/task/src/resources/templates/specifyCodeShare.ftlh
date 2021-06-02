<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Code</title>
        <link rel="stylesheet"
              target="_blank" href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
        <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
        <script>hljs.initHighlightingOnLoad();</script>
    </head>
    <body>
        <p>create date: <span id="load_date">${codeShare.date}</span></p>
        <#if codeShare.viewsRestriction>
            <p><span id="views_restriction">${codeShare.views}</span> more views allowed</p>
        </#if>
        <#if codeShare.dueDateRestriction>
            <p>The code will be available for <span id="time_restriction">${codeShare.time}</span> seconds</p>
        </#if>

        <pre id="code_snippet">
            <code>
                ${codeShare.code}
            </code>
        </pre>
    </body>
</html>