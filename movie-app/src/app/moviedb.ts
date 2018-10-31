export interface MovieDb{
    id:string,
    movie:string,
    comments:string,
    poster_path:string,
    adult:boolean,
    overview:string,
    release_date:string,
    genre_ids:Array<number>,
    original_title:string,
    original_language:string,
    backdrop_path:string,
    popularity:number,
    vote_count:number,
    video:boolean,
    vote_average:number
}