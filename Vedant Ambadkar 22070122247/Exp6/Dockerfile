FROM python:3.12.7

WORKDIR /app
COPY app.py .
RUN pip install flask

EXPOSE 8081
CMD ["python", "app.py"]