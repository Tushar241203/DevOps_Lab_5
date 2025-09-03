import json
from app import app


def test_root():
client = app.test_client()
resp = client.get("/")
assert resp.status_code == 200
data = json.loads(resp.data)
assert data["ok"] is True
assert data["service"] == "flask-demo"