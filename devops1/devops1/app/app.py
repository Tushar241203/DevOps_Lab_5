from flask import Flask


app = Flask(__name__)


@app.get("/")
def root():
return {"ok": True, "service": "flask-demo", "version": "1.0.0"}


if __name__ == "__main__":
app.run(host="0.0.0.0", port=8000)