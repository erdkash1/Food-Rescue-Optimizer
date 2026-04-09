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

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/donors | Register a food donor |
| POST | /api/donors/{id}/food-items | Submit a food item |
| POST | /api/optimize | Run the AI route optimizer |

## Live Demo

API running at: http://3.239.9.70:8081