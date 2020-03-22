package com.example.reactivewithlifecycleaware.util

import com.google.gson.Gson

object Data {

    val modelsRawJson = """
        {
          "model": [
            {
              "id": 1,
              "name": "X1",
              "brand": "BMW",
              "description": "Codenamed the F48, the new second-generation X1 is the first existing BMW model range to adopt a transverse engine layout, similar to the newly minted front-wheel drive 2 Active Tourer and 2 Grand Tourer model range. Unlike its predecessor, this all new X1 didn’t have to live with a longitudinal engine that limited cabin space and lent it a strange proportion. Instead this new X1 looks like a junior X5 with its balanced design proportions and better still, a spacious cabin for all occupants.",
              "year": 2020,
              "price": "USD 35.000",
              "detail": {
                "bodyType": "SUV",
                "transmission": "Auto",
                "engineCapacity": "2000cc",
                "seatCapacity": "5"
              },
              "review": {
                "rating": 8.4,
                "spec": {
                  "critic": 9.1,
                  "performance": 8.1,
                  "interior": 8.1,
                  "safety": 9.1
                }
              },
              "gallery": {
                "images": [
                  "https://cars.usnews.com/static/images/Auto/custom/14244/Exterior_1.jpg",
                  "https://cars.usnews.com/static/images/Auto/custom/14244/Exterior_2.jpg",
                  "https://cars.usnews.com/static/images/Auto/custom/14244/Exterior_3.jpg",
                  "https://cars.usnews.com/static/images/Auto/custom/14244/Exterior_4.jpg",
                  "https://cars.usnews.com/static/images/Auto/custom/14244/Exterior_5.jpg"
                ]
              }
            },
            {
              "id": 2,
              "name": "Fit",
              "brand": "Honda",
              "description": "The 2020 Honda Fit ranks near the top of the subcompact car class. It boasts a spacious and handsome cabin with a configurable rear seat that makes cargo hauling a cinch, and it's available with a bounty of advanced driver aids.",
              "year": 2020,
              "price": "USD 36.000",
              "detail": {
                "bodyType": "Hatchback",
                "transmission": "Manual",
                "engineCapacity": "2000cc",
                "seatCapacity": "4"
              },
              "review": {
                "rating": 8.5,
                "spec": {
                  "critic": 9.1,
                  "performance": 8.1,
                  "interior": 8.1,
                  "safety": 9.1
                }
              },
              "gallery": {
                "images": [
                  "https://cars.usnews.com/static/images/Auto/izmo/i159580472/2020_honda_civic_angularfront.jpg",
                  "https://cars.usnews.com/static/images/Auto/izmo/i159580472/2020_honda_civic_angularrear.jpg",
                  "https://cars.usnews.com/static/images/Auto/izmo/i159580472/2020_honda_civic_sideview.jpg",
                  "https://cars.usnews.com/static/images/Auto/izmo/i159580472/2020_honda_civic_frontview.jpg",
                  "https://cars.usnews.com/static/images/Auto/izmo/i159580472/2020_honda_civic_rearview.jpg"
                ]
              }
            },
            {
              "id": 3,
              "name": "A4",
              "brand": "Audi",
              "description": "The 2020 Audi A4 ranks near the top of the luxury small car class. It offers refined engine performance, balanced handling, a comfy and upscale interior, and intuitive tech features.",
              "year": 2020,
              "price": "USD 37.000",
              "detail": {
                "bodyType": "Sedan",
                "transmission": "Auto",
                "engineCapacity": "2000cc",
                "seatCapacity": "5"
              },
              "review": {
                "rating": 8.5,
                "spec": {
                  "critic": 9.1,
                  "performance": 8.1,
                  "interior": 8.1,
                  "safety": 9.1
                }
              },
              "gallery": {
                "images": [
                  "https://cars.usnews.com/static/images/Auto/custom/14355/2020_Audi_A4_5.jpg",
                  "https://cars.usnews.com/static/images/Auto/custom/14355/2020_Audi_A4_6.jpg",
                  "https://cars.usnews.com/static/images/Auto/custom/14355/2020_Audi_A4_7.jpg",
                  "https://cars.usnews.com/static/images/Auto/custom/14355/2020_Audi_A4_12.jpg",
                  "https://cars.usnews.com/static/images/Auto/custom/14355/2020_Audi_A4_2.jpg"
                ]
              }
            }
          ]
        }
    """.trimIndent()

    fun getCarModels(): List<CarModel> {
        return Gson().fromJson<CarResponse>(
            modelsRawJson, CarResponse::class.java).model
    }

}

data class CarResponse(
    val model: List<CarModel>
)

data class CarModel(
    val id: Long,
    val name: String,
    val brand: String,
    val description: String,
    val year: Int,
    val price: String,
    val detail: CarDetail,
    val review: CarReview,
    val gallery: CarGalery
)

data class CarDetail(
    val bodyType: String,
    val transmission: String,
    val engineCapacity: String,
    val seatCapacity: String
)

data class CarReview(
    val rating: Double,
    val spec: ReviewSpec,
    val totalReview: Int
)

data class CarGalery(
    val images: List<String>
)

data class ReviewSpec(
    val critic: Double,
    val performance: Double,
    val interior: Double,
    val safety: Double
)
