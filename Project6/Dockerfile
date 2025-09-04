FROM python:3.13.1

WORKDIR /app
COPY app.py .
RUN pip install flask

EXPOSE 8081
CMD ["python", "app.py"]