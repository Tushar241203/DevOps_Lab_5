FROM node:18-alpine AS builder
WORKDIR /app
COPY app/package*.json ./
RUN npm ci --omit=dev || npm install --omit=dev
COPY app/ .

# Create a group and user, assign user to group
RUN addgroup -S app && adduser -S -G app app

USER app

FROM node:18-alpine
WORKDIR /app
COPY --from=builder /app /app
EXPOSE 3000
CMD ["node", "index.js"]
