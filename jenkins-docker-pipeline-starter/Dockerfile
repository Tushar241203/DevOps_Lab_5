# Multi-stage build for a tiny Node web app
FROM node:18-alpine AS builder
WORKDIR /app
COPY app/package*.json ./
# Install only production deps (none in this tiny example, but good practice)
RUN npm ci --omit=dev || npm install --omit=dev
COPY app/ .
RUN addgroup -S app && adduser -S app -G app
USER app

FROM node:18-alpine
WORKDIR /app
COPY --from=builder /app /app
EXPOSE 3000
CMD ["node", "index.js"]
