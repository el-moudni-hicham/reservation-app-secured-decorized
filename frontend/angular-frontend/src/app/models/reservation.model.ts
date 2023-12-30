import { Reservator } from "./reservator.model"
import { Resource } from "./resource.model"

export interface Reservation {
    id: number
    name: string
    context: string
    date: string
    duration: number
    person: Reservator
    idResource: number
    resource: Resource
  }
  
