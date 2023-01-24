<!DOCTYPE html>
<html>
<head>
  <title>Trip Management API</title>
  <!-- Swagger UI CSS -->
  <link href="https://cdn.jsdelivr.net/npm/swagger-ui-dist@3/swagger-ui.css" rel="stylesheet" type="text/css">
</head>
<body>
  <div id="swagger-ui"></div>
  <!-- Swagger UI JS -->
  <script src="https://cdn.jsdelivr.net/npm/swagger-ui-dist@3/swagger-ui-bundle.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/swagger-ui-dist@3/swagger-ui-standalone-preset.js"></script>
  <script>
    window.onload = function() {
      // Build the Swagger UI
      const ui = SwaggerUIBundle({
        url: "http://localhost:8080/v2/api-docs",
        dom_id: '#swagger-ui',
        deepLinking: true,
        presets: [
          SwaggerUIBundle.presets.apis,
          SwaggerUIStandalonePreset
        ],
        layout: "StandaloneLayout"
      })
      window.ui = ui
    }
  </script>
</body>
</html>
