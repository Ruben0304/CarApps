package ruben.hernandez.rentalcar
import com.apollographql.apollo.ApolloClient

object ApolloGraphQL {

    val apolloClient = ApolloClient.Builder()
        .serverUrl("https://car-app-backend-lac.vercel.app/graphql")
        .build()

}