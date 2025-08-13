#!/bin/bash

echo "🚀 Building Angular Docker Application"

# Build development environment
echo "📦 Building development environment..."
docker-compose -f docker-compose.dev.yml build

# Build production environment
echo "📦 Building production environment..."
docker-compose build

echo "✅ Build completed successfully!"
echo ""
echo "To run development environment:"
echo "  docker-compose -f docker-compose.dev.yml up"
echo ""
echo "To run production environment:"
echo "  docker-compose up"