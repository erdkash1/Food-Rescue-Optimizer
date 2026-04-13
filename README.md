# Food Rescue Optimizer

A production-grade AI-powered food rescue logistics system built with Java 21 and Spring Boot.

## What It Does

Food waste is a global problem. This system connects food donors (restaurants, supermarkets) with recipients (food banks, shelters) and uses AI to optimize pickup and delivery routes — minimizing distance, saving fuel, and ensuring food reaches people before it spoils.

## Key Features

- **Donor Registration** — donors submit available food items with quantity and expiry time
- **AI Route Optimizer** — Timefold solver assigns vehicles to pickups using constraint-based optimization
- **ML Spoilage Scorer** — logistic regression model predicts spoilage risk based on food category, temperature, and hours until expiry
- **Automated Database Migrations** — Flyway manages schema versioning
- **Cloud Deployed** — running on AWS ECS Fargate with RDS PostgreSQL

## Tech Stack

- Java 21, Spring Boot 3.4.4
- Timefold AI (constraint solver)
- Smile (machine learning)
- PostgreSQL + Flyway
- Docker, AWS ECS, AWS RDS

## API Documentation

Interactive API docs available at: http://localhost:8081/swagger-ui/index.html

Live docs on AWS: http://3.238.51.54:8081/swagger-ui/index.html

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/donors | Register a food donor |
| GET | /api/donors | List all donors |
| GET | /api/donors/{id} | Get donor by ID |
| POST | /api/donors/{id}/food-items | Submit a food item |
| POST | /api/recipients | Register a recipient |
| GET | /api/recipients | List all recipients |
| GET | /api/recipients/{id} | Get recipient by ID |
| POST | /api/vehicles | Add a vehicle |
| GET | /api/vehicles | List all vehicles |
| GET | /api/vehicles/{id} | Get vehicle by ID |
| POST | /api/optimize | Run the AI route optimizer |

## Live Demo

Live API: http://3.238.51.54:8081